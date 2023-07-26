class DisjointSet {
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    
    DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }
    
    int findUParent(int node) {
        if (node == parent.get(node)) return node;
        int ulp = findUParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    
    void unionBySize(int u, int v) {
        int ulpU = findUParent(u), ulpV = findUParent(v);
        if (ulpU == ulpV) return;
        if (size.get(ulpU) < size.get(ulpV)) {
            parent.set(ulpU, ulpV);
            size.set(ulpV, size.get(ulpU) + size.get(ulpV));
        } else {
            parent.set(ulpV, ulpU);
            size.set(ulpU, size.get(ulpU) + size.get(ulpV));
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int len = accounts.size();
        DisjointSet ds = new DisjointSet(len);
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int ilen = accounts.get(i).size();
            for (int j = 1; j < ilen; j++) {
                String tmp = accounts.get(i).get(j);
                if (!map.containsKey(tmp)) map.put(tmp, i);
                else ds.unionBySize(i, map.get(tmp));
            }
        }
        ArrayList<String>[] tmp = new ArrayList[len];
        for (int i = 0; i < len; i++) tmp[i] = new ArrayList<String>();
        for (Map.Entry<String, Integer> it : map.entrySet()) {
            String mail = it.getKey();
            int node = ds.findUParent(it.getValue());
            tmp[node].add(mail);
        }
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (tmp[i].size() == 0) continue;
            ArrayList<String> txp = new ArrayList<>();
            txp.add(accounts.get(i).get(0));
            Collections.sort(tmp[i]);
            for (String s : tmp[i]) txp.add(s);
            res.add(txp);
        }
        return res;
    }
}
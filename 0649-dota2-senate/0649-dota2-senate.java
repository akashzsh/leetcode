class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiants = new LinkedList<>();
        Queue<Integer> dires = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiants.offer(i);
            } else {
                dires.offer(i);
            }
        }
        
        while (!radiants.isEmpty() && !dires.isEmpty()) {
            if (radiants.peek() < dires.peek()) {
                radiants.offer(n + 1);
            } else {
                dires.offer(n + 1);
            }
            n++;
            radiants.remove();
            dires.remove();
        }
        
        return radiants.isEmpty() ? "Dire" : "Radiant";
    }
}
class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int checkPoint = 0, count = 0;
        switch(ruleKey) {
            case "type":
                checkPoint = 0;
                break;
            case "color":
                checkPoint = 1;
                break;
            case "name":
                checkPoint = 2;
                break;
        }
        for (int i = 0; i < items.size(); i++) {            
            if (items.get(i).get(checkPoint).equals(ruleValue)) count++;
        }
        return count;
    }
}
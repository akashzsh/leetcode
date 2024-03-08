class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] balance = new int[2];
        // balance stores available [five, ten]
        
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                balance[0]++;
            } else if (bills[i] == 10) {
                if (balance[0] <= 0) {
                    return false;
                } else {
                    balance[0]--;
                    balance[1]++;
                }
            } else {
                if (balance[0] >= 1 && balance[1] >= 1) {
                    balance[0]--;
                    balance[1]--;
                } else {
                    if (balance[0] >= 3) {
                        balance[0] -= 3;
                    } else {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}


// line number 17
/*

first check if we have 10 along with 5 so that big note (10) go away first... instead of first paying with couple of 5 coins.. because 5 can be included in all transactions so it may be needed later on

*/
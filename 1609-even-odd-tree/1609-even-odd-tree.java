class Solution {
	public boolean isEvenOddTree(TreeNode root) {
		Queue < TreeNode > q = new LinkedList < >();
		q.add(root);
		int curLvl = -1;

		while (!q.isEmpty()) {
            int size = q.size();
			curLvl++;
            TreeNode popped = q.poll();

			if (curLvl % 2 == 0) {
				if (popped.val % 2 == 0) {
					return false;
				}
			} else {
				if (popped.val % 2 != 0) {
					return false;
				}
			}

			if (popped.left != null) {
				q.add(popped.left);
			}

			if (popped.right != null) {
				q.add(popped.right);
			}
            
            int cur = -1;
            int prev = popped.val;

			for (int i = 1; i < size; i++) {
				popped = q.poll();

				cur = popped.val;

				if (curLvl % 2 == 0) {
					if (popped.val % 2 == 0 || cur <= prev) {
						return false;
					}
				} else {
					if (popped.val % 2 != 0 || cur >= prev) {
						return false;
					}
				}

				if (popped.left != null) {
					q.add(popped.left);
				}

				if (popped.right != null) {
					q.add(popped.right);
				}

				prev = cur;
			}
		}

		return true;
	}
}
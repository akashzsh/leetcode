class Pair {
    int endTime;
    int id;
    
    Pair(int endTime, int id) {
        this.endTime = endTime;
        this.id = id;
    }
}

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        TreeMap<Integer, Integer> booked = new TreeMap<>();
        PriorityQueue<Integer> free = new PriorityQueue<>();
        PriorityQueue<Pair> full = new PriorityQueue<>((a, b) -> a.endTime == b.endTime ? a.id - b.id : a.endTime - b.endTime);
        
        for (int i = 0; i < n; i++) {
            free.add(i);
        }
        
        for (int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0], end = meetings[i][1];
            
            // If there is some room which was occupied but now is free
            while (!full.isEmpty() && full.peek().endTime <= start) {
                free.add(full.poll().id);
            }
            
            if (!free.isEmpty()) {
                int id = free.poll();
                booked.put(id, booked.getOrDefault(id, 0) + 1);
                full.add(new Pair(end, id));
            } else {
                Pair p = full.poll();
                booked.put(p.id, booked.getOrDefault(p.id, 0) + 1);
                full.add(new Pair(p.endTime + end - start, p.id));
            }
        }
        
        int maxRoomId = -1, maxMeetings = 0;
        for (Integer room : booked.keySet()) {
            if (booked.get(room) > maxMeetings) {
                maxRoomId = room;
                maxMeetings = booked.get(room);
            }
        }
        
        return maxRoomId;
    }
}
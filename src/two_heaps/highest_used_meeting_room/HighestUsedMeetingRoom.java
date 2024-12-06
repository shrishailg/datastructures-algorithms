package two_heaps.highest_used_meeting_room;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class HighestUsedMeetingRoom {

    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<RoomCount> roomCountsPriorityQueue = new PriorityQueue<>(n, new Comparator<RoomCount>() {
            @Override
            public int compare(RoomCount o1, RoomCount o2) {
                if (o1.count == o2.count)
                    return o1.count;
                return o1.count - o2.count;
            }
        });

        PriorityQueue<RoomEndTime> roomEndTimePriorityQueue = new PriorityQueue<>(n, new Comparator<RoomEndTime>(){
            @Override
            public int compare(RoomEndTime o1, RoomEndTime o2){
                return o1.meetingEnd - o2.meetingEnd;
            }
        });

        for (int i=0;i<n;i++){
            roomCountsPriorityQueue.add(new RoomCount(i, 0));
        }

        for(int[] meeting: meetings){
            while (!roomEndTimePriorityQueue.isEmpty() && roomEndTimePriorityQueue.peek().meetingEnd <= meeting[1]){
                // reset end time to 0
                roomEndTimePriorityQueue.poll();
            }

            if (!roomCountsPriorityQueue.isEmpty()) {
                RoomCount roomCount = roomCountsPriorityQueue.poll();
                roomCount.count++;
                roomCountsPriorityQueue.add(roomCount);
            }

        }

        return 0;
    }
}

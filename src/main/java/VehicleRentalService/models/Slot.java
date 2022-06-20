package VehicleRentalService.models;

import java.time.LocalDateTime;

public class Slot {
    private int startTime;
    private int endTime;

    public Slot(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}

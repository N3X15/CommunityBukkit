package org.bukkit.event.vehicle;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.Cancellable;

/**
 * Raised when a living entity exits a vehicle.
 */
public class VehicleExitEvent extends VehicleEvent implements Cancellable {
    private boolean cancelled;
    private LivingEntity exited;

    public VehicleExitEvent(Vehicle vehicle, LivingEntity exited) {
        super(Type.VEHICLE_EXIT, vehicle);
        this.exited = exited;
    }

    /**
     * Get the living entity that exited the vehicle.
     *
     * @return
     */
    public LivingEntity getExited() {
        return exited;
    }

    /**
     * Gets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins
     *
     * @return true if this event is cancelled
     */
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Sets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins
     *
     * @param cancel true if you wish to cancel this event
     */
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}

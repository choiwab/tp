package seedu.address.model.appointment;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import seedu.address.commons.util.OptionalUtil;
import seedu.address.commons.util.ToStringBuilder;

/**
 * Represents an appointment's details in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class AppointmentDescriptor {

    private final AppointmentType appointmentType;
    private final LocalDateTime appointmentDateTime;
    private final Optional<Sickness> sickness;
    private final Optional<Medicine> medicine;

    /**
     * Every field must be present and not null.
     */
    public AppointmentDescriptor(
            AppointmentType appointmentType,
            LocalDateTime appointmentDateTime,
            Optional<Sickness> sickness,
            Optional<Medicine> medicine) {
        requireAllNonNull(appointmentType, appointmentDateTime);
        this.appointmentType = appointmentType;
        this.appointmentDateTime = appointmentDateTime;
        this.sickness = sickness;
        this.medicine = medicine;
    }

    public AppointmentType getAppointmentType() {
        return this.appointmentType;
    }

    public LocalDateTime getAppointmentDateTime() {
        return this.appointmentDateTime;
    }

    public Optional<Sickness> getSickness() {
        return this.sickness;
    }

    public Optional<Medicine> getMedicine() {
        return this.medicine;
    }

    /**
     * Returns true if both appointments have the same appointmentDateTime and appointmentType.
     * This defines a weaker notion of equality between two appointments.
     */
    public boolean isSameAppointment(AppointmentDescriptor otherAppointment) {
        if (otherAppointment == this) {
            return true;
        }

        // todo: add other checks for equality
        return otherAppointment != null
                && otherAppointment.getAppointmentDateTime().equals(getAppointmentDateTime())
                && otherAppointment.getAppointmentType().equals(getAppointmentType());
    }

    /**
     * Returns true if both appointments have the same appointmentDateTime and appointmentType.
     * This defines a weaker notion of equality between two appointments.
     */
    public boolean isSameAppointment(Appointment otherAppointment) {
        return otherAppointment != null
                && otherAppointment.getAppointmentDateTime().equals(getAppointmentDateTime())
                && otherAppointment.getAppointmentDateTime().equals(getAppointmentDateTime());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AppointmentDescriptor otherAppointment)) {
            return false;
        }

        return appointmentType.equals(otherAppointment.getAppointmentType())
                && appointmentDateTime.equals(otherAppointment.getAppointmentDateTime())
                && sickness.equals(otherAppointment.getSickness())
                && medicine.equals(otherAppointment.getMedicine());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(appointmentType, appointmentDateTime, sickness, medicine);
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this)
                .add("appointment type", appointmentType)
                .add("appointment datetime", appointmentDateTime)
                .add("sickness", OptionalUtil.optionalToString(sickness))
                .add("medicine", OptionalUtil.optionalToString(medicine));

        return builder.toString();
    }
}

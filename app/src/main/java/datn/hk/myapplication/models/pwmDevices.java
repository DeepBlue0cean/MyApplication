package datn.hk.myapplication.models;

import javax.annotation.Nonnull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@NonNull
public class pwmDevices {
    private boolean status;
    private int value;
    private String turnOn, turnOff;
}

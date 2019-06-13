package datn.hk.myapplication.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Kitchen {
    //public final static String TEM = "/home";
    private  String gas;
    private  String fire;
    private  String tem;
    private  String hum;



}

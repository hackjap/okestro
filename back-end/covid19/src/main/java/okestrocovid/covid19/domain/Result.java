package okestrocovid.covid19.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {

    //int  count;
    private T data;
}

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main
{
    public static void main(String[] args)
    {
        LocalDateTime d;

        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd-hh");
        System.out.println(f);
    }
}

package Practice_Interface;

public class AustralianTrafic implements CentralTraffic,ContinentalTraffic {

    public static void main(String[] args) {
        CentralTraffic a= new AustralianTrafic();
        a.redStop();
        a.FlashYellow();
        a.greenGo();

        AustralianTrafic at=new AustralianTrafic();
        ContinentalTraffic ct=new AustralianTrafic();
        at.walkonsymbol();
        ct.Trainsymbol();
    }
    public void walkonsymbol()
    {
        System.out.println("walking");
    }

    @Override
    public void greenGo() {
        System.out.println(" Green go implementation");
    }

    @Override
    public void redStop() {
        System.out.println(" redstop implementation");
    }

    @Override
    public void FlashYellow() {
        System.out.println(" flash yellow implementation");
    }

    @Override
    public void Trainsymbol() {

    }
}

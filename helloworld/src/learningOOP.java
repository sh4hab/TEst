public class learningOOP {
    int x;
    public learningOOP(){
        x = 5 ;
    }
    static void myMethod(){
        System.out.println("This text is from the first Method !!! ");
    }
    /*static void mymethod2(){
        learningOOP Main = new learningOOP();
        Main.x = 5 ;
        System.out.println(Main.x);
    }*/
    public static void main(String[] arg){
        myMethod();
      //  mymethod2();
        learningOOP myobj = new learningOOP();
        System.out.println(myobj.x);
      /*  learningOOP myObj=new learningOOP() ;
        learningOOP myObj3=new learningOOP() ;
        myObj.x = 25 ;
        myObj3.x = 40 ;
        System.out.println("the first obj : " +myObj.x +"\nand the second obj :"+ myObj3.x);
        Main myObj2 = new Main();
        System.out.println(myObj.x);
        System.out.println(myObj2.x);*/
    }
}


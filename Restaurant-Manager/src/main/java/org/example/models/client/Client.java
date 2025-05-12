package org.example.models.client;


import java.util.UUID;

public class Client {
    private int wartoscPortfela;
    private final int wiek;
    private final String uid;
    private String login;
    private String password;

    //Nowy Klient przychodzi do baru (generujemy uid)
    public Client(int wartoscPortfela, int wiek) {
        this.wartoscPortfela = wartoscPortfela;
        this.wiek = wiek;
        this.uid = UUID.randomUUID().toString();
    }

    //Klient który przyszedł więcej niż raz i jego dane bierzymy z serwera
    //(ewentualnie jakieś sprawdzanie żeby było profeszonal)
    public Client(int wartoscPortfela, int wiek, String uid) {
        this.wartoscPortfela = wartoscPortfela;
        this.wiek = wiek;
        this.uid = uid;
    }
    // Ludzki dla mnie konstruktor - tomek
    public Client(String uid,int age,int money,String login,String password){
        this.uid =uid;
        this.wiek = age;
        this.wartoscPortfela = money;
        this.login = login;
        this.password = password;
    }

    public void zaplac(float kwota, float napiwek) {
        //zakładam, że to będzie działać na zasadzie pobierania wartości z rachunku lub na odwrót

        /*
            Rachunek rachunek = new Rachunek(uid); <- uid aby wiedzieć jak rachunek płacić
            ranchunek.zaplac(); <- jakaś weryfikacja, że cię stać
            ...
        */
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public int zwrocWiek() {
        return wiek;
    }

    public String zwrocUid() {
        return uid;
    }

    public int getWartoscPortfela() {
        return wartoscPortfela;
    }
    public String toCSV(){
        return String.format("%s;%d;%d",this.uid,this.wiek,this.wartoscPortfela);
    }
}
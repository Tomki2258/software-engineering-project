package org.example.models.client;


import java.util.UUID;

public class Client {
    private int wartoscPortfela;
    private int wiek;
    private final String uid;


    //Nowy Klient przyhcodzi do baru
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

    public void zaplac(float kwota, float napiwek) {

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
}
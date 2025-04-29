package org.example.models.client;


import java.util.UUID;

public class Client {
    private int wartoscPortfela;
    private int wiek;
    private final String uid;


    //
    public Client(int wartoscPortfela, int wiek) {
        this.wartoscPortfela = wartoscPortfela;
        this.wiek = wiek;
        this.uid = UUID.randomUUID().toString();
    }

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

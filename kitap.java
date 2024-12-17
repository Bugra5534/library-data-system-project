public class kitap {
    private String id;
    private String baslik;
    private String yazar;
    private int yil;
    private boolean oduncAlindiMi;
    private double gecikmesabiti = 5.0;

    public kitap(String id, String baslik, String yazar, int yil) {
        this.id = id;
        this.baslik = baslik;
        this.yazar = yazar;
        this.yil = yil;
        this.oduncAlindiMi = false;
    }
    public String getId() {
        return id;
    }
    public boolean isOduncAlindiMi() {
        return oduncAlindiMi;
    }
    public void oduncVer() {
        if (oduncAlindiMi) {
            System.out.println("Kitap zaten ödünç alınmış.");
        } else {
            oduncAlindiMi = true;
            System.out.println("Kitap başarıyla ödünç verildi.");
        }
    }
    public void geriAl(int gecikmegünü) {
        if (!oduncAlindiMi) {
            System.out.println("Kitap zaten kütüphanede.");
        } else {
            oduncAlindiMi = false;
            double gecikmeucreti = gecikmegünü*gecikmesabiti;
            System.out.println("Kitap başarıyla geri alındı.");
            if (gecikmeucreti>0){
                System.out.println("Gecikme ücreti: " + gecikmeucreti + " TL");
            }
            else{
                System.out.println("Gecikme ücreti yok.");
            }
        }
    }
    @Override
    public String toString() {
        return "Kitap ID: " + id + ", Başlık: " + baslik + ", Yazar: " + yazar + ", Yıl: " + yil+
        ", Ödünç Alındı mı: " + (oduncAlindiMi ? "Evet" : "Hayır");
    }
}


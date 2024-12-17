import java.util.Scanner;

public class kütüphane extends kitap {
   
    public kütüphane(String id, String baslik, String yazar, int yil) {
        super(id, baslik, yazar, yil);
    }
    public static void main(String[]args){
 
      Scanner input = new Scanner(System.in);

      System.out.println("Kaç kitap eklemek istiyorsunuz?");
      int kitapsayisi = input.nextInt();

      kitap[] kitaplar = new kitap[kitapsayisi];
      
      for (int i=0; i< kitapsayisi;i++){
         System.out.println("Kitap ID giriniz:");
         String id = input.next();

         System.out.println("Kitap başlığı giriniz:");
         String baslik = input.next();

         System.out.println("Kitap yazarı giriniz:");
         String yazar = input.next();

         System.out.println("Kitap yayın yılı giriniz:");
         int yil = input.nextInt();
         
         kitaplar[i] = new kitap(id,baslik,yazar,yil);
      }
      System.out.println("Eklenen kitaplar:");
      for(kitap kitap:kitaplar){

       System.out.println(kitap);

      }
        boolean devam = true;
        while (devam) {
            System.out.println("Bir işlem seçin: 1) Kitapları Listele 2) Kitap Ödünç Ver 3) Kitap Geri Al 4) Çıkış");
            int secim = input.nextInt();
            input.nextLine();
            
            switch (secim) {
                case 1:
                    System.out.println("Eklenen kitaplar:");
                    for (kitap kitap : kitaplar) {
                        System.out.println(kitap);
                    }
                    break;
                case 2:
                    System.out.println("Ödünç vermek istediğiniz kitabın ID'sini girin:");
                    String oduncId = input.nextLine();
                    boolean bulundu = false;
                    for (kitap kitap : kitaplar) {
                        if (kitap.getId().equals(oduncId)) {
                            kitap.oduncVer();
                            bulundu = true;
                            break;
                        }
                    }
                    if (!bulundu) {
                        System.out.println("Kitap bulunamadı.");
                    }
                    break;
                case 3:
                    System.out.println("Geri almak istediğiniz kitabın ID'sini girin:");
                    String geriAlId = input.nextLine();
                    bulundu = false;
                    for (kitap kitap : kitaplar) {
                        if (kitap.getId().equals(geriAlId)) {
                            System.out.println("Kaç gün gecikti?");
                            int gecikmegunsayisi = input.nextInt();
                            input.nextLine();
                            kitap.geriAl(gecikmegunsayisi);
                            bulundu = true;
                            break;
                        }
                    }
                    if (!bulundu) {
                        System.out.println("Kitap bulunamadı.");
                    }
                    break;
                case 4:
                    devam = false;
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }

        input.close();
    }
}
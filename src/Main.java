
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String namaAwal, namaAkhir, jenisUser;
        int pilihanCetak;
        Order pesan;
        Lembar cetak;
        Scanner scan = new Scanner(System.in);
        System.out.println("Selamat datang di Percetakan FILKOM");
        System.out.println("===================================");
        System.out.printf("Masukkan nama pertama anda : ");
        namaAwal = scan.nextLine();
        System.out.printf("Masukkan nama akhir anda : ");
        namaAkhir = scan.nextLine();
        System.out.println("===================================");

        System.out.print("Apakah anda member ?(Y/N)\nJawaban anda: ");
        jenisUser = scan.next();
        Customer c1;
        if (jenisUser.equalsIgnoreCase("y")) {
            c1 = new Member();
            Member member = (Member) c1;
            member.setFirstName(namaAwal);
            member.setLastName(namaAkhir);
            System.out.print("Silahkan masukkan member ID anda: ");
            member.setIdNumber(scan.next() + scan.nextLine());
            member.setJoinDate();
            System.out.println();
            System.out.println("Selamat datang di Percetakan FILKOM, kak " + member.getFullName()
                    + ".\nSilahkan isi data berikut untuk membuat pesanan.");
            member.makeOrder();
            int x = 0;
            do {
                pesan = member.getPesanan();
                System.out.println("");
                System.out.println("===================================");
                System.out.print("Pilihan mencetak :\n (1) Cetak Biasa\n (2) Buku\n (3) Jilid");
                System.out.print("\nJawaban anda : ");
                pilihanCetak = scan.nextInt();
                if (pilihanCetak == 1) {
                    cetak = new Lembar();
                } else if (pilihanCetak == 2) {
                    cetak = new Buku();
                    Buku p2 = (Buku) cetak;
                    System.out.println("===================================");
                    System.out.print("Masukkan nama buku yang ingin anda cetak\n");
                    System.out.print("Jawaban anda : ");
                    scan.nextLine();
                    String namaBuku = scan.nextLine();
                    p2.setNamaBuku(namaBuku);

                    int jenisCo;
                    do {
                        System.out.println("===================================");
                        System.out.println("Jenis cover yang ingin anda gunakan\n (1) Hard Cover\n (2) Soft Cover");
                        System.out.print("Pilihan anda : ");
                        jenisCo = scan.nextInt();
                        p2.setJenisCover(jenisCo);
                    } while (jenisCo > 2 || jenisCo < 1);
                } else {
                    cetak = new Jilid();
                    Jilid p2 = (Jilid) cetak;
                    int JenisJilid;
                    do {
                        System.out.println("===================================");
                        System.out.print(
                                "Jenis jilid yang akan anda gunakan : \n (1) Jilid Spiral\n (2) Jilid Mika/Buffalo\n (3) Jilid Buffalo\n");
                        System.out.print("Jawaban anda : ");
                        JenisJilid = scan.nextInt();
                        p2.setJenisJilid(JenisJilid);
                    } while (JenisJilid < 1 || JenisJilid > 3);
                }
                boolean penentu = false;
                if (cetak instanceof Buku) {
                    penentu = true;
                }
                int jKertas;
                do {
                    System.out.println("===================================");
                    System.out.print(
                            "Kertas apa yang anda ingin gunakan?\n (1) HVS\n (2) Kertas Samson\n (3) Kertas Foto \n");
                    System.out.print("Pilihan anda : ");
                    jKertas = scan.nextInt();
                    cetak.setJenisKertas(jKertas);
                    System.out.println("===================================");
                } while (jKertas > 3 || jKertas < 1);

                int jUkuranLembar;
                do {
                    System.out.print("Ukuran kertas : \n (1) A4\n (2) A5\n (3) B4\n (4) B5\n");
                    System.out.print("Pilihan anda : ");
                    cetak.setUkuranLembar(jUkuranLembar = scan.nextInt());
                    System.out.println("===================================");
                } while (jUkuranLembar > 4 || jUkuranLembar < 1);

                int jSetWarna = 0;
                do {
                    System.out.print("Warna tinta yang ingin dicetak : \n (1) Hitam Putih\n (2) Berwarna\n");
                    System.out.print("Pilihan anda : ");
                    cetak.setWarna(jSetWarna = scan.nextInt());
                    System.out.println("===================================");
                } while (jSetWarna < 1 || jSetWarna > 2);

                if (penentu == false) {
                    int jJenisCetak = 0;
                    do {
                        System.out.print(
                                "Jenis cetak apakah yang anda inginkan?\n (1) Cetak satu sisi\n (2) Cetak dua sisi\n");
                        System.out.print("Pilihan anda : ");
                        jJenisCetak = scan.nextInt();
                        cetak.setJenisCetak(jJenisCetak);
                        System.out.println("===================================");
                    } while (jJenisCetak > 2 || jJenisCetak < 1);
                }
                int jJumlahHalaman = 0;
                do {
                    System.out.print("Jumlah halaman yang ingin anda cetak\n");
                    System.out.print("Jawaban anda : ");
                    cetak.setJumlahHalaman(jJumlahHalaman = scan.nextInt());
                    System.out.println("===================================");
                    if (jJumlahHalaman < 1)
                        System.out.println("Jumlah halaman pasti lebih dari 0");
                } while (jJumlahHalaman < 1);

                int jJumlahCetak = 0;
                do {
                    System.out.print("Anda ingin mencetak sebanyak berapa kali?\n");
                    System.out.print("Jawaban anda : ");
                    cetak.setJumlahCetak(jJumlahCetak = scan.nextInt());
                    System.out.println("===================================");
                    if (jJumlahCetak < 1) {
                        System.out.println("Jumlah cetak pasti lebih dari 0");
                    }
                } while (jJumlahCetak < 1);

                int jJenisLayanan = 0;
                do {
                    System.out.print("Jenis layanan yang anda inginkan\n (1) Cetak dari fail\n (2) Fotocopy\n");
                    System.out.print("Pilihan anda : ");
                    cetak.setJenisLayanan(jJenisLayanan = scan.nextInt());
                    System.out.println("===================================");
                } while (jJenisLayanan < 1 || jJenisLayanan > 2);
                cetak.setHargaWarna();
                cetak.setHargaCetak();
                cetak.setHarga();
                if (cetak instanceof Buku) {
                    ((Buku) cetak).setHargaCover();
                    pesan.addItem(cetak);
                    pesan.setSubTotalBiaya(pesan.getSubTotalBiaya() + ((Buku) cetak).getHargaBuku());
                } else if (cetak instanceof Jilid) {
                    ((Jilid) cetak).setHargaJilid();
                    ((Jilid) cetak).setHargaJilidTotal();
                    pesan.addItem(cetak);
                    pesan.setSubTotalBiaya(pesan.getSubTotalBiaya() + ((Jilid) cetak).getHargaJilidTotal());
                } else {
                    pesan.addItem(cetak);
                    pesan.setSubTotalBiaya(pesan.getSubTotalBiaya() + cetak.getHarga());
                }
                do {
                    System.out.print("Apakah anda ingin pesan lagi\n1. Ya\n2. Tidak\nPilihan Anda: ");
                    x = scan.nextInt();
                    System.out.println("===================================");
                } while (x < 1 || x > 2);

            } while (x != 2);

            double jo;
            do {
                System.out.println("Berapakah jarak titik antar dari Percetakan FILKOM? \n(dalam Km)");
                jo = scan.nextDouble();
                scan.nextLine();
                pesan.setJarak(jo);
                pesan.setOngkosKirim();
            } while (jo <= 0);

            System.out.print("Apakah anda ingin checkout\n1. Ya\n2. Tidak\nPilihan Anda: ");
            int y = scan.nextInt();
            scan.nextLine();
            System.out.println();
            System.out.println("===================================");

            if (y == 1) {
                System.out.println("***********************************");
                pesan.checkOut();
                System.out.println("***********************************");
                System.out.println("===================================");
                System.out.println();

                PercentOffPromo pop = new PercentOffPromo(pesan, member);
                CashbackPromo cp = new CashbackPromo(pesan, member);
                DeliveryFeePromo dfp = new DeliveryFeePromo(pesan, member);

                System.out.println("Silahkan Masukkan Kode Promo : ");
                String promo = scan.nextLine();
                if (promo.equalsIgnoreCase("2023CERIA")) {
                    int a=pop.compareTo(cp) + pop.compareTo(dfp), b = cp.compareTo(dfp) + cp.compareTo(pop),
                            c = dfp.compareTo(cp) + dfp.compareTo(pop);
                    pop.setDiscount();
                    cp.setDiscount();
                    dfp.setDiscount();
                    System.out.println("Silahkan Pilih Discount Anda: ");
                    if (a==Math.max(a, Math.max(b, c))) {
                        System.out.println("Percent Off(1): " + pop.getDiscount());
                        if(b==Math.max(b, c)) {
                            System.out.println("Cashback(2): " +cp.getDiscount());
                            System.out.println("Delivery Fee(3): " +dfp.getDiscount());
                        }
                        else {
                            System.out.println("Delivery Fee(3): " +dfp.getDiscount());
                            System.out.println("Cashback(2): " +cp.getDiscount());
                        }
                    }
                    else if (b==Math.max(b, Math.max(a, c))) {
                        System.out.println("Cashback(2): " +cp.getDiscount());
                        if(a==Math.max(a, c)) {
                            System.out.println("Percent Off(1): " + pop.getDiscount());
                            System.out.println("Delivery Fee(3): " +dfp.getDiscount());
                        }
                        else {
                            System.out.println("Delivery Fee(3): " +dfp.getDiscount());
                            System.out.println("Percent Off(1): " + pop.getDiscount());
                        }
                    }else {
                        System.out.println("Delivery Fee(3): " +dfp.getDiscount());
                        if(a==Math.max(a, b)) {
                            System.out.println("Percent Off(1): " + pop.getDiscount());
                            System.out.println("Cashback(2): " +cp.getDiscount());
                        }
                        else {
                            System.out.println("Cashback(2): " +cp.getDiscount());
                            System.out.println("Percent Off(1): " + pop.getDiscount());
                        }
                    }
                    int pro = scan.nextInt();
                    scan.nextLine();
                    if(pro == 1) {
                        pesan.applyPromo(pop);
                    }else if(pro==2) {
                        pesan.applyPromo(cp);
                    }else {
                        pesan.applyPromo(dfp);
                    }

                } else {
                    System.out.println("Mohon maaf kode promo yang anda masukkan salah.");
                }

                System.out.print("Apakah anda ingin membayar? \n1. Ya\n2. Tidak\nPilihan Anda: ");
                y = scan.nextInt();
                System.out.println("===================================");
                if (y == 1) {
                    System.out.println();
                    System.out.println();
                    pesan.pay();
                    pesan.printDetails();

                } else {
                    pesan.setStatusPesanan(2);
                    System.out.println(pesan.getStatusPesanan());
                }
            }


        }

        else {
            c1 = new Guest();
            Guest guest = (Guest) c1;
            guest.setFirstName(namaAwal);
            guest.setLastName(namaAkhir);

            System.out.println("Selamat datang di Percetakan FILKOM, kak " + guest.getFullName()
                    + ". Silahkan isi data berikut untuk membuat pesanan.");
            guest.makeOrder();
            int x = 0;
            do {
                pesan = guest.getPesanan();
                System.out.println("");
                System.out.println("===================================");
                System.out.print("Pilihan mencetak :\n (1) Cetak Biasa\n (2) Buku\n (3) Jilid");
                System.out.print("\nJawaban anda : ");
                pilihanCetak = scan.nextInt();
                if (pilihanCetak == 1) {
                    cetak = new Lembar();
                } else if (pilihanCetak == 2) {
                    cetak = new Buku();
                    Buku p2 = (Buku) cetak;
                    System.out.println("===================================");
                    System.out.print("Masukkan nama buku yang ingin anda cetak\n");
                    System.out.print("Jawaban anda : ");
                    scan.nextLine();
                    String namaBuku = scan.nextLine();
                    p2.setNamaBuku(namaBuku);

                    int jenisCo;
                    do {
                        System.out.println("===================================");
                        System.out.println("Jenis cover yang ingin anda gunakan\n (1) Hard Cover\n (2) Soft Cover");
                        System.out.print("Pilihan anda : ");
                        jenisCo = scan.nextInt();
                        p2.setJenisCover(jenisCo);
                    } while (jenisCo > 2 || jenisCo < 1);
                } else {
                    cetak = new Jilid();
                    Jilid p2 = (Jilid) cetak;
                    int JenisJilid;
                    do {
                        System.out.println("===================================");
                        System.out.print(
                                "Jenis jilid yang akan anda gunakan : \n (1) Jilid Spiral\n (2) Jilid Mika/Buffalo\n (3) Jilid Buffalo\n");
                        System.out.print("Jawaban anda : ");
                        JenisJilid = scan.nextInt();
                        p2.setJenisJilid(JenisJilid);
                    } while (JenisJilid < 1 || JenisJilid > 3);
                }
                boolean penentu = false;
                if (cetak instanceof Buku) {
                    penentu = true;
                }
                int jKertas;
                do {
                    System.out.println("===================================");
                    System.out.print(
                            "Kertas apa yang anda ingin gunakan?\n (1) HVS\n (2) Kertas Samson\n (3) Kertas Foto \n");
                    System.out.print("Pilihan anda : ");
                    jKertas = scan.nextInt();
                    cetak.setJenisKertas(jKertas);
                    System.out.println("===================================");
                } while (jKertas > 3 || jKertas < 1);

                int jUkuranLembar;
                do {
                    System.out.print("Ukuran kertas : \n (1) A4\n (2) A5\n (3) B4\n (4) B5\n");
                    System.out.print("Pilihan anda : ");
                    cetak.setUkuranLembar(jUkuranLembar = scan.nextInt());
                    System.out.println("===================================");
                } while (jUkuranLembar > 4 || jUkuranLembar < 1);

                int jSetWarna = 0;
                do {
                    System.out.print("Warna tinta yang ingin dicetak : \n (1) Hitam Putih\n (2) Berwarna\n");
                    System.out.print("Pilihan anda : ");
                    cetak.setWarna(jSetWarna = scan.nextInt());
                    System.out.println("===================================");
                } while (jSetWarna < 1 || jSetWarna > 2);

                if (penentu == false) {
                    int jJenisCetak = 0;
                    do {
                        System.out.print(
                                "Jenis cetak apakah yang anda inginkan?\n (1) Cetak satu sisi\n (2) Cetak dua sisi\n");
                        System.out.print("Pilihan anda : ");
                        jJenisCetak = scan.nextInt();
                        cetak.setJenisCetak(jJenisCetak);
                        System.out.println("===================================");
                    } while (jJenisCetak > 2 || jJenisCetak < 1);
                }
                int jJumlahHalaman = 0;
                do {
                    System.out.print("Jumlah halaman yang ingin anda cetak\n");
                    System.out.print("Jawaban anda : ");
                    cetak.setJumlahHalaman(jJumlahHalaman = scan.nextInt());
                    System.out.println("===================================");
//                    if (jJumlahHalaman < 1)
//                        System.out.println("Jumlah halaman pasti lebih dari 0");
                } while (jJumlahHalaman < 1);

                int jJumlahCetak = 0;
                do {
                    System.out.print("Anda ingin mencetak sebanyak berapa kali?\n");
                    System.out.print("Jawaban anda : ");
                    cetak.setJumlahCetak(jJumlahCetak = scan.nextInt());
                    System.out.println("===================================");
//                    if (jJumlahCetak < 1) {
//                        System.out.println("Jumlah cetak pasti lebih dari 0");
//                    }
                } while (jJumlahCetak < 1);

                int jJenisLayanan = 0;
                do {
                    System.out.print("Jenis layanan yang anda inginkan\n (1) Cetak dari fail\n (2) Fotocopy\n");
                    System.out.print("Pilihan anda : ");
                    cetak.setJenisLayanan(jJenisLayanan = scan.nextInt());
                    System.out.println("===================================");
                } while (jJenisLayanan < 1 || jJenisLayanan > 2);
                cetak.setHargaWarna();
                cetak.setHargaCetak();
                cetak.setHarga();
                if (cetak instanceof Buku) {
                    ((Buku) cetak).setHargaCover();
                    pesan.addItem(cetak);
                    pesan.setSubTotalBiaya(pesan.getSubTotalBiaya() + ((Buku) cetak).getHargaBuku());
                } else if (cetak instanceof Jilid) {
                    ((Jilid) cetak).setHargaJilid();
                    ((Jilid) cetak).setHargaJilidTotal();
                    pesan.addItem(cetak);
                    pesan.setSubTotalBiaya(pesan.getSubTotalBiaya() + ((Jilid) cetak).getHargaJilidTotal());
                } else {
                    pesan.addItem(cetak);
                    pesan.setSubTotalBiaya(pesan.getSubTotalBiaya() + cetak.getHarga());
                }
                do {
                    System.out.print("Apakah anda ingin pesan lagi\n1. Ya\n2. Tidak\nPilihan Anda: ");
                    x = scan.nextInt();
                    System.out.println("===================================");
                } while (x < 1 || x > 2);

            } while (x != 2);
            System.out.print("Apakah anda ingin checkout\n1. Ya\n2. Tidak\nPilihan Anda: ");
            int y = scan.nextInt();
            scan.nextLine();
            System.out.println();
            System.out.println("===================================");

            System.out.print("Apakah anda ingin membayar? \n1. Ya\n2. Tidak\nPilihan Anda: ");
            y = scan.nextInt();
            System.out.println("===================================");
            if (y == 1) {
                System.out.println();
                System.out.println();
                pesan.pay();
                pesan.printDetails();

            } else {
                pesan.setStatusPesanan(2);
                System.out.println(pesan.getStatusPesanan());
            }
        }
    }
}

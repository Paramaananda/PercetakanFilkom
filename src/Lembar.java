public class Lembar {
    private String jenisKertas;
    private String ukuranLembar;
    private String warna;
    private String jenisCetak;
    private int jumlahCetak;
    private String jenisLayanan;
    private int jumlahHalaman;
    private int hargaWarna;
    private int hargaCetak;
    private int harga;

    public Lembar(){
        super();
        this.jenisKertas = "HVS";
        this.ukuranLembar = "A4";
        this.warna = "Hitam Putih";
        this.jenisCetak = "Cetak satu sisi";
        this.jumlahCetak = 1;
        this.jenisLayanan = "Cetak dari fail";
        harga = 0;
    }
    public void setHargaCetak() {
        if (jenisCetak.equals("Cetak satu sisi")){
            hargaCetak = 500;
        }
        else {
            hargaCetak = 1000;
        }
    }

    public void setHarga() {
        this.harga = (hargaWarna + hargaCetak)*jumlahHalaman*jumlahCetak;
    }

    public void setHargaWarna() {
        if (warna.equals("Berwarna")){
            hargaWarna = 1000;
        }
        else {
            hargaWarna = 500;
        }
    }
    public void setJenisKertas(int slot) {
        try {
            if (slot > 0 && slot < 4) {
                if (slot == 1) {
                    this.jenisKertas = "HVS";
                }
                if (slot == 2) {
                    this.jenisKertas = "Kertas Samson";
                }
                if (slot == 3) {
                    this.jenisKertas = "Kertas Foto";
                }
            } else {
                throw new Exception("Mohon memilih sesuai menu");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void setUkuranLembar(int slot) {
        try {
            if (slot > 0 && slot < 5) {
                if (slot == 1) {
                    this.ukuranLembar = "A4";
                }
                if (slot == 2) {
                    this.ukuranLembar = "A5";
                }
                if (slot == 3) {
                    this.ukuranLembar = "B4";
                }
                if (slot == 4) {
                    this.ukuranLembar = "B5";
                }
            } else {
                throw new Exception("Mohon memilih sesuai menu");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void setWarna(int slot) {
        try {
            if (slot > 0 && slot < 3) {
                if (slot == 1) {
                    this.warna = "Hitam Putih";
                }
                if (slot == 2) {
                    this.warna = "Berwarna";
                }
            } else {
                throw new Exception("Mohon memilih sesuai menu");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void setJenisCetak(int slot) {
        try {
            if (slot > 0 && slot < 3) {
                if (slot == 1) {
                    this.jenisCetak = "Cetak satu sisi";
                }
                if (slot == 2) {
                    this.jenisCetak = "Cetak dua sisi";
                }
            } else {
                throw new Exception("Mohon memilih sesuai menu");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void setJumlahCetak(int jumlahCetak) {
        this.jumlahCetak = jumlahCetak;
    }

    public void setJenisLayanan(int slot) {
        try {
            if (slot > 0 && slot < 3) {
                if (slot == 1) {
                    this.jenisLayanan = "Cetak dari fail";
                }
                if (slot == 2) {
                    this.jenisLayanan = "Fotocopy";
                }
            } else {
                throw new Exception("Mohon untuk memilih sesuai menu");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void setJumlahHalaman(int jumlahHalaman) {
        try {
            if (jumlahHalaman > 1) {
                this.jumlahHalaman = jumlahHalaman;
            } else {
                throw new Exception("Jumlah Halaman Pasti Lebih Dari 0");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public int getHarga() {
        return harga;
    }

    public String getJenisKertas() {
        return jenisKertas;
    }

    public String getUkuranLembar() {
        return ukuranLembar;
    }

    public String getWarna() {
        return warna;
    }

    public String getJenisCetak() {
        return jenisCetak;
    }

    public int getJumlahCetak() {
        return jumlahCetak;
    }

    public String getJenisLayanan() {
        return jenisLayanan;
    }
    public int getJumlahHalaman() {

        return jumlahHalaman;
    }
    public String toString (){
        return "Cetak Lembar sebanyak " + jumlahHalaman +
                " halaman, harga : " + harga;
    }
}


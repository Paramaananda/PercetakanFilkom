public class Buku extends Lembar {
    private String jenisCover;
    private String namaBuku;
    private int hargaCover;
    private int hargaBuku ;

    Buku() {
        super();
        setJenisCetak(2);
    }

    public void setJenisCover(int slot) {
        try {
            if (slot > 0 && slot < 3) {
                if (slot == 1) {
                    this.jenisCover = "Hard Cover";
                }
                if (slot == 2) {
                    this.jenisCover = "Soft Cover";
                }
            } else {
                throw new Exception("Mohon Memilih sesuai menu");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void setHargaCover() {
        if (jenisCover.equals("Hard cover")){
            hargaCover = 5000;
        }
        else {
            hargaCover = 4000;
        }
    }
    public void setNamaBuku(String namaBuku) {
        this.namaBuku = namaBuku;
    }

    public String getJenisCover() {
        return jenisCover;
    }

    public String getNamaBuku() {
        return namaBuku;
    }
    public int getHargaCover() {
        return hargaCover;
    }
    public int getHargaBuku() {
        return getHarga()+hargaCover;
    }
    @Override
    public String toString() {
        return "Cetak buku berjudul \"" + getNamaBuku() + "\" harga : " +getHargaBuku();
    }
}


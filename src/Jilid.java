public class Jilid extends Lembar {
    private String jenisJilid;
    private int hargaJilid;
    private int hargaJilidTotal ;

    public Jilid() {
        super();
        this.jenisJilid = "Jilid Spiral";
        hargaJilid = 0;
    }

    public void setJenisJilid(int slot) {
        try {
            if (slot > 0 && slot < 3) {
                if (slot == 1) {
                    this.jenisJilid = "Jilid Spiral";
                } else if (slot == 2) {
                    this.jenisJilid = "Jilid Mika/Buffalo";
                } else {
                    this.jenisJilid = "Jilid Buffalo";
                }
            } else {
                throw new Exception("Mohon Memilih sesuai menu");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void setHargaJilid() {
        if (jenisJilid.equals("Jilid spiral")) {
            hargaJilid = 3000;
        } else if (jenisJilid.equals("Jilid Mika/Buffalo")) {
            hargaJilid = 4000;
        } else {
            hargaJilid = 2000;
        }
    }

    public void setHargaJilidTotal() {
        this.hargaJilidTotal = getHarga()+hargaJilid;
    }

    public String getJenisJilid() {
        return jenisJilid;
    }

    public int getHargaJilid() {
        return hargaJilid ;
    }

    public int getHargaJilidTotal() {
        return hargaJilidTotal;
    }

    @Override
    public String toString() {
        return "Cetak jilid " + getJenisJilid() + " harga : " + getHargaJilidTotal();
    }
}
public class Weapon {

    // === ATRIBUT ===
    public String namaWeapon;
    public String tipeWeapon;
    public int    damage;

    // CONSTRUCTOR DEFAULT
    public Weapon() {
        this.namaWeapon = "Bare Hands";
        this.tipeWeapon = "Hand-to-Hand";
        this.damage     = 10;
    }

    // CONSTRUCTOR BERPARAMETER
    public Weapon(String namaWeapon, String tipeWeapon, int damage) {
        this.namaWeapon = namaWeapon;
        this.tipeWeapon = tipeWeapon;
        this.damage     = damage;
    }

    // METHOD 1: Hitung damage berdasarkan ignition level pemilik
    public int hitDamage(int ignitionLevel) {
        int total = (int)(damage * (1.0 + ignitionLevel / 10.0));
        System.out.println("    [" + namaWeapon + "] " + damage
                + " x ignisi(lvl " + ignitionLevel + ") = " + total);
        return total;
    }

    // METHOD 2: Tampilkan info senjata
    public void displayInfo() {
        System.out.println("    Senjata : " + namaWeapon + " (" + tipeWeapon + ")");
        System.out.println("    Damage  : " + damage);
    }

    // Getter & Setter
    public String getNamaWeapon()          { return namaWeapon; }
    public void   setNamaWeapon(String n)  { this.namaWeapon = n; }
    public String getTipeWeapon()          { return tipeWeapon; }
    public void   setTipeWeapon(String t)  { this.tipeWeapon = t; }
    public int    getDamage()              { return damage; }
    public void   setDamage(int d)         { this.damage = d; }
}

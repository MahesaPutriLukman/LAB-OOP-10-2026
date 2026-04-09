public class FireSoldier {

    // === ATRIBUT ===
    public String nama;
    public int    hp;
    public int    ignitionLevel;
    public Weapon weapon;          

    // CONSTRUCTOR DEFAULT
    public FireSoldier() {
        this.nama          = "Rekrut Baru";
        this.hp            = 100;
        this.ignitionLevel = 1;
        this.weapon        = new Weapon();
    }

    // CONSTRUCTOR BERPARAMETER
    public FireSoldier(String nama, int hp, int ignitionLevel, Weapon weapon) {
        this.nama          = nama;
        this.hp            = hp;
        this.ignitionLevel = ignitionLevel;
        this.weapon        = weapon;
    }

    // METHOD 1: activateIgnition()    
    public int activateIgnition() {
        System.out.println("\n  [" + nama + "] mengaktifkan ignition! (level " + ignitionLevel + ")");

        int damage = weapon.hitDamage(ignitionLevel);

        if (ignitionLevel < 10) {
            ignitionLevel++;
            System.out.println("    Ignition level naik -> " + ignitionLevel);
        }

        System.out.println("    Total damage: " + damage);
        return damage;
    }

    // METHOD 2: battle(FireSoldier enemy)
    public void battle(FireSoldier enemy) {
        System.out.println("\n+------------------------------------------+");
        System.out.println("  BATTLE: " + this.nama + "  VS  " + enemy.nama);
        System.out.println("+------------------------------------------+");

        int ronde = 1;
        while (this.hp > 0 && enemy.hp > 0 && ronde <= 8) {
            System.out.println("\n--- Ronde " + ronde + " ---");

            int dmg1 = this.activateIgnition();
            enemy.hp -= dmg1;
            System.out.println("  >> " + enemy.nama + " HP: " + Math.max(enemy.hp, 0));

            if (enemy.hp <= 0) break;

            int dmg2 = enemy.activateIgnition();
            this.hp -= dmg2;
            System.out.println("  >> " + this.nama + " HP: " + Math.max(this.hp, 0));

            ronde++;
        }

        System.out.println("\n+------------------------------------------+");
        if (this.hp > 0 && enemy.hp <= 0) {
            System.out.println("  PEMENANG: " + this.nama + "!");
        } else if (enemy.hp > 0 && this.hp <= 0) {
            System.out.println("  PEMENANG: " + enemy.nama + "!");
        } else {
            System.out.println("  HASIL: DRAW!");
        }
        System.out.println("+------------------------------------------+\n");
    }

    public void displayStatus() {
        System.out.println("\n--- Status: " + nama + " ---");
        System.out.println("  HP             : " + hp);
        System.out.println("  Ignition Level : " + ignitionLevel);
        weapon.displayInfo();
    }

    public String getNama()                 { return nama; }
    public void   setNama(String n)         { this.nama = n; }
    public int    getHp()                   { return hp; }
    public void   setHp(int h)              { this.hp = h; }
    public int    getIgnitionLevel()        { return ignitionLevel; }
    public void   setIgnitionLevel(int l)   { this.ignitionLevel = l; }
    public Weapon getWeapon()               { return weapon; }
    public void   setWeapon(Weapon w)       { this.weapon = w; }
}

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Senjata karakter
        Weapon bootsShinra   = new Weapon("Devil's Footprints", "Boots",  35);
        Weapon swordArthur   = new Weapon("Excalibur Plasma",   "Sword",  40);
        Weapon fistBenimaru  = new Weapon("Hellfire Fist",      "Fists",  45);
        Weapon cardJoker     = new Weapon("Joker's Card",       "Card",   38);
        Weapon staffBoss     = new Weapon("Holy Staff of Ash",  "Staff",  55);

        // Fire Soldiers
        FireSoldier shinra   = new FireSoldier("Shinra Kusakabe",  130, 9,  bootsShinra);
        FireSoldier arthur   = new FireSoldier("Arthur Boyle",     120, 7,  swordArthur);
        FireSoldier benimaru = new FireSoldier("Benimaru Shinmon", 150, 10, fistBenimaru);
        FireSoldier joker    = new FireSoldier("Joker",            140, 8,  cardJoker);

        // Final Boss (pakai constructor berparameter)
        FireSoldier boss     = new FireSoldier("The Evangelist",   200, 10, staffBoss);

        // ════════════════════════════════════════════
        //   TAMPILAN AWAL
        // ════════════════════════════════════════════
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("      FIRE FORCE  -  Holy War Tournament    ");
        System.out.println("╚══════════════════════════════════════════╝");

        System.out.println("\n  Daftar karakter:");
        System.out.println("  ┌─────────────────────────────────────────────────┐");
        System.out.println("  │ 1. Shinra Kusakabe  │ HP:130 │ IGN:9  │ Boots   │");
        System.out.println("  │ 2. Arthur Boyle     │ HP:120 │ IGN:7  │ Sword   │");
        System.out.println("  │ 3. Benimaru Shinmon │ HP:150 │ IGN:10 │ Fists   │");
        System.out.println("  │ 4. Joker            │ HP:140 │ IGN:8  │ Card    │");
        System.out.println("  └─────────────────────────────────────────────────┘");

        // ════════════════════════════════════════════
        //   BABAK SEMIFINAL 1
        // ════════════════════════════════════════════
        System.out.println("\n══════════════════════════════════════════");
        System.out.println("  SEMIFINAL 1");
        System.out.println("══════════════════════════════════════════");
        System.out.println("  Pilih Fighter A (1-4): ");
        int pA = sc.nextInt();
        System.out.println("  Pilih Fighter B (1-4, beda dari A): ");
        int pB = sc.nextInt();

        FireSoldier fighterA = getKarakter(pA, shinra, arthur, benimaru, joker);
        FireSoldier fighterB = getKarakter(pB, shinra, arthur, benimaru, joker);

        // Reset HP sebelum battle
        resetHP(fighterA, pA);
        resetHP(fighterB, pB);

        fighterA.battle(fighterB);
        FireSoldier pemenang1 = (fighterA.hp > 0) ? fighterA : fighterB;
        System.out.println("  >> Melaju ke Final: " + pemenang1.nama + "!");

        // ════════════════════════════════════════════
        //   BABAK SEMIFINAL 2
        // ════════════════════════════════════════════
        System.out.println("\n══════════════════════════════════════════");
        System.out.println("  SEMIFINAL 2");
        System.out.println("══════════════════════════════════════════");
        System.out.println("  Pilih Fighter C (1-4, beda dari Semifinal 1): ");
        int pC = sc.nextInt();
        System.out.println("  Pilih Fighter D (1-4, beda dari C): ");
        int pD = sc.nextInt();

        FireSoldier fighterC = getKarakter(pC, shinra, arthur, benimaru, joker);
        FireSoldier fighterD = getKarakter(pD, shinra, arthur, benimaru, joker);

        resetHP(fighterC, pC);
        resetHP(fighterD, pD);

        fighterC.battle(fighterD);
        FireSoldier pemenang2 = (fighterC.hp > 0) ? fighterC : fighterD;
        System.out.println("  >> Melaju ke Final: " + pemenang2.nama + "!");

        // ════════════════════════════════════════════
        //   BABAK GRAND FINAL vs THE EVANGELIST
        // ════════════════════════════════════════════
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("        ★  GRAND FINAL  ★                  ");
        System.out.println("  " + pemenang1.nama + "  &  " + pemenang2.nama);
        System.out.println("          VS");
        System.out.println("       THE EVANGELIST (FINAL BOSS)          ");
        System.out.println("╚══════════════════════════════════════════╝");

        // Reset HP pemenang dan boss sebelum final
        resetHP(pemenang1, pA);
        resetHP(pemenang2, pC);
        boss.setHp(200);
        boss.setIgnitionLevel(10);

        // Pemenang 1 duel boss dulu
        System.out.println("\n  >> Ronde Final - " + pemenang1.nama + " maju duluan!");
        pemenang1.battle(boss);

        // Jika boss masih hidup, pemenang 2 lanjut
        if (boss.hp > 0) {
            System.out.println("\n  >> Boss masih hidup! " + pemenang2.nama + " turun tangan!");
            pemenang2.battle(boss);
        }

        // ════════════════════════════════════════════
        //   HASIL AKHIR
        // ════════════════════════════════════════════
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("              HASIL AKHIR                   ");
        if (boss.hp <= 0) {
            System.out.println("   The Evangelist DIKALAHKAN!");
            System.out.println("   Special Fire Brigade MENANG! Dunia selamat!");
        } else {
            System.out.println("   The Evangelist MENANG...");
            System.out.println("   Special Fire Brigade kalah. Dunia dalam bahaya!");
        }
        System.out.println("╚══════════════════════════════════════════╝");

        sc.close();
    }

    // ── Helper: kembalikan karakter sesuai nomor ──
    public static FireSoldier getKarakter(int pilihan,
            FireSoldier shinra, FireSoldier arthur,
            FireSoldier benimaru, FireSoldier joker) {
        switch (pilihan) {
            case 1: return shinra;
            case 2: return arthur;
            case 3: return benimaru;
            case 4: return joker;
            default:
                System.out.println("  Pilihan tidak valid, default ke Shinra.");
                return shinra;
        }
    }

    // ── Helper: reset HP sesuai karakter aslinya ──
    public static void resetHP(FireSoldier f, int nomor) {
        switch (nomor) {
            case 1: f.setHp(130); f.setIgnitionLevel(9);  break;
            case 2: f.setHp(120); f.setIgnitionLevel(7);  break;
            case 3: f.setHp(150); f.setIgnitionLevel(10); break;
            case 4: f.setHp(140); f.setIgnitionLevel(8);  break;
        }
    }
}

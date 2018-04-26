package UiJogo;

import java.util.Scanner;
import logicaJogo.Estados.*;

import logicaJogo.Estados.IEstado;
import logicaJogo.DadosJogo;
import logicaJogo.Jogo;


/*

    TODO LIST
-Evento archers Attack -> feito
-Evento Boiling water -> feito * pode haver bugs 
-Evento Close Combat -> feito * pode haver bugs 
-Evento Coupure - feito * falta testes intensivos
-Evento Rally troops
-Evento Tunnel Movement
-Evento Supply raid
-Evento Sabotage

-Evento perder instantaneamente 
-Evento ganhar 
-Evento perder no fim de turno


-falta fazer o tunel
-falta fazer o movimento das tropas no tunel
-falta 1 ou outro evento das cartas 

-correção de bugs
-melhroar USER INTERFACE 

-testar 

 */
public class UiTexto {

    private Jogo jogo;
    boolean primeiraJogada = true;
    boolean sair = false;

    public UiTexto(Jogo jogo) {
        this.jogo = jogo;
    }

    void iuAguardaInicio() {

        System.out.println("1 - Novo Jogo\n2 - Sair");
        char c = ' ';
        Scanner sc = new Scanner(System.in);
        c = sc.next().charAt(0);
        if (c == '1') {
            System.out.println("Insira o nome do jogador: ");
            String nome = sc.next();
            jogo.defineNomeJogador(nome);
            System.out.println("Nome: " + nome);
            jogo.comecarJogo();
            return;
        }
        if (c == '2') {
            sair = true;
            return;
        }
    }

    void baseUi() {
        String s = new String();

        System.out.println(jogo.getLog());
        jogo.setLog("");
        System.out.println(jogo.toStringCarta());
        System.out.println(jogo.toStringDados());
    }

    void uiArchersAttack() {
        int c = -1;
        while (true) {
            baseUi();
            System.out.println("Choosed Action: Archers Attack");
            System.out.println("Choose Track: " + (jogo.hasLadders() ? "1 - Ladders\t" : "")
                    + (jogo.hasBattRam() ? "2 - Battering Ram\t" : "")
                    + (jogo.hasSiegeTower() ? "3 - Siege Tower\t" : "")
                    + "4 - voltar");

            Scanner sc = new Scanner(System.in);
            try {

                c = sc.nextInt();
                if (c == 4) {
                    jogo.voltarAcao();
                    return;
                }
                jogo.realizarArchersAttack(c);
                return;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Opção Invalida!");
            }
        }

    }

    void uiBoilingWater() {
        int c = -1;
        while (true) {
            baseUi();
            System.out.println("Choosed Action: Boiling Water Attack");
            System.out.println("Choose Track: " + (jogo.laddersIncircle() ? "1 - Ladders\t" : "")
                    + (jogo.battRamInCircle() ? "2 - Battering Ram\t" : "")
                    + (jogo.siegeTowerInCircle() ? "3 - Siege Tower\t" : "")
                    + "4 - voltar");

            Scanner sc = new Scanner(System.in);
            try {

                c = sc.nextInt();
                if (c == 4) {
                    jogo.voltarAcao();
                    return;
                }
                jogo.realizarBoilingWaterAttack(c);
                return;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Opção Invalida!");
            }
        }
    }

    void uiCloseCombatAttack() {
        int c = -1;
        while (true) {
            baseUi();
            System.out.println("Choosed Action: Close Combat Attack");
            System.out.println("Choose Track: " + (jogo.closeCombatUnits()[0] != 0 ? "0 - 1º Space \t" : "")
                    + (jogo.closeCombatUnits()[1] != 0 ? "1 - 2º Space\t" : "")
                    + "2 - voltar");

            Scanner sc = new Scanner(System.in);
            try {

                c = sc.nextInt();
                if (c == 2) {
                    jogo.voltarAcao();
                    return;
                }
                jogo.realizarCloseCombatAttack(c);
                return;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Opção Invalida!");
            }
        }
    }

    void uiRallyTroops() {
        int c = -1;
        while (true) {
            baseUi();
            System.out.println("Choosed Action: Rally Troops");
            System.out.println("Reduce Supplies for Bonus?: 1 - Yes  2 - No 3 - Back");
            Scanner sc = new Scanner(System.in);
            try {

                c = sc.nextInt();
                if (c == 3) {
                    jogo.voltarAcao();
                    return;
                }
                jogo.realizarRallyTroops(c);
                return;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Opção Invalida!");
            }
        }
    }

    void uiTunnelMovement() {
        int c = -1;
        while (true) {
            baseUi();
            System.out.println("Choosed Action: Tunnel Movement");
            System.out.println("Choose Movement : 1 - Free Movement  2 - Fast Movement 3 - Back");
            Scanner sc = new Scanner(System.in);
            try {

                c = sc.nextInt();
                if (c == 3) {
                    jogo.voltarAcao();
                    return;
                }
                jogo.realizarTunnelMovement(c);
                return;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Opção Invalida!");
            }
        }
    }

    void iuAguardaAcao() {
        int c = -1;
        while (true) {
            baseUi();
            System.out.println("1 - Archers Attack \t"
                    + (jogo.troopsInCircleSpaces() && jogo.unusedBoilingWater() ? "2 - Boilling Water Attack\t " : "")
                    + (jogo.troopsIncloseCombat() ? " 3 - CloseCombat Attack" : ""));
            System.out.println((jogo.wallStrg() < 4 ? "4 - Coupure\t" : "")
                    + (jogo.playerMorale() < 4 ? "5 - Rally Troops\t" : "") + "  6 - Tunnel Movement\t 7 - Supply Raid");
            System.out.println("8 - Sabotage\t 9 - Mudar de Turno\t 0 - Sair");

            Scanner sc = new Scanner(System.in);
            try {
                c = sc.nextInt();
                if (c == 0) {
                    return;
                } else if (c >= 1 && c <= 8) {
                    jogo.realizarAccao(c);
                    return;
                } else if (c == 9) {
                    jogo.mudarTurno();
                    return;
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("Opção Invalida!");
            }
        }
    }

    void corre() {
        while (!sair) {
            IEstado estado = jogo.getEstado();
            if (estado instanceof AguardaInicio) {
                iuAguardaInicio();
            } else if (estado instanceof AguardaCarta) {
                jogo.retirarCarta();
            } else if (estado instanceof AguardaAccao) {
                iuAguardaAcao();
            } else if (estado instanceof AguardaArchersAttack) {
                uiArchersAttack();
            } else if (estado instanceof AguardaBoilingWaterAttack) {
                uiBoilingWater();
            } else if (estado instanceof AguardaCloseCombatAttack) {
                if (jogo.troopsIncloseCombatCount() > 1) {
                    uiCloseCombatAttack();
                } else {
                    jogo.realizarCloseCombatAttack();
                }
            } else if (estado instanceof AguardaRallyTroops) {
                uiRallyTroops();
            } else if (estado instanceof AguardaTunnelMovement) {
                uiTunnelMovement();
            }
        }
    }
}

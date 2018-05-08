package UiJogo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import logicaJogo.Estados.*;

import logicaJogo.Estados.IEstado;
import logicaJogo.GereFicheirosJogo;
import logicaJogo.Jogo;


/*

    TODO LIST
-Evento archers Attack -> feito
-Evento Boiling water -> feito * pode haver bugs 
-Evento Close Combat -> feito * pode haver bugs 
-Evento Coupure - feito * falta testes intensivos
-Evento Rally troops - done
-Evento Tunnel Movement - done
-Evento Supply raid - done
-Evento Sabotage - done
-Evento trocar 1 de morale ou 1 supply por 1 action point - done

jp - o que fiz / o que falta fazer/testar
-guardar/carregar jogo - done(pelo menos parece)
-Recuar as tropas para o castelo - done +/- : no endOfDay(recolher mantimentos e soma à var supplies no máx até 4) : 
                                - checkar ainda pois meti as posiçoes do array a 0 à excepção da 1º, ver se é isso
                                - ver também se o ponto 13 do enunciado está feito
-Evento perder instantaneamente - função checkEnemiesCloseCombat , se retornar true no fim do turno é pq existem 2 enimigos da close combat e perde
                                - fiz também código para obrigar a jogar quando existem 2 enimigos da close combat
-Evento ganhar - ganha se passar os 3 dias: feito no endOfDay : novo estado FimJogo para poder começar novo jogo
-Evento perder no fim de turno : descrito em cima + validação quando algum recurso no fim do turno é = 0
                                - verificar também quando um terceiro elemento do inimigo vai para a close combat, assim perde logo e o array é só de 2 posições
-falta o evento Bad weather - Done


Falta:
-onde por o perder automaticamente, ele já está preparado com uma flag no Dados de jogo "perdeu" chamada atravez do metodo .isPerdeu()
-correção de bugs
-ter em cuidado valores negativos: ex.: Siege Tower Bonus: -1
-melhorar USER INTERFACE 
-testar 

 */
public class UiTexto {

    private Jogo jogo;
    boolean primeiraJogada = true;
    boolean sair = false;

    public UiTexto(Jogo jogo) {
        this.jogo = jogo;
    }

    void iuFimJogo() {
        String s = new String();
        s = jogo.getLog();
        System.out.println("\n----------------------- " + s + " -----------------------\n");
        jogo.novoJogo();
        jogo = new Jogo();
    }

    void iuAguardaInicio() throws IOException, FileNotFoundException, ClassNotFoundException {

        System.out.println("1 - Novo Jogo\n2 - Carregar Jogo\n3 - Sair");
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
            //nao testado
            System.out.println("Insira o nome do jogo a carregar: ");
            String nomeFicheiro = sc.next();
            //pedir nome de jogador ou carregar também
            jogo = GereFicheirosJogo.carregaJogo(nomeFicheiro);
            jogo.comecarJogo();
            return;
        }
        if (c == '3') {
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

    void uiExtraPoints() {
        int c = -1;
        while (true) {
            baseUi();
            System.out.println("Choosed Action: Extra Action Point");
            System.out.println("Choose to lower: 1 - Morale  2 - Supplies 3 - Back");
            Scanner sc = new Scanner(System.in);
            try {

                c = sc.nextInt();
                if (c == 3) {
                    jogo.voltarAcao();
                    return;
                }
                jogo.realizarExtraPoint(c);
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

            if (jogo.badWeather()) {
                System.out.println("0 - Extra Action point\t");
                System.out.println( (jogo.TroopsInEnemyLines() ? "7 - Supply Raid" : ""));
                System.out.println((jogo.TroopsInEnemyLines() ? "8 - Sabotage\t" : "")
                        + "9 - Mudar de Turno\t 10 - Guardar\t 11 - Menu\t 12 - Sair ");
            } else {
                System.out.println("0 - Extra Action point\t 1 - Archers Attack \t"
                        + (jogo.troopsInCircleSpaces() && jogo.unusedBoilingWater() ? "2 - Boilling Water Attack\t" : "")
                        + (jogo.troopsIncloseCombat() ? " 3 - CloseCombat Attack" : ""));
                System.out.println((jogo.wallStrg() < 4 ? " 4 - Coupure\t" : "")
                        + (jogo.playerMorale() < 4 ? "5 - Rally Troops\t" : "") + " 6 - Tunnel Movement\t "
                        + (jogo.TroopsInEnemyLines() ? "7 - Supply Raid" : ""));
                System.out.println((jogo.TroopsInEnemyLines() ? "8 - Sabotage\t" : "")
                        + "9 - Mudar de Turno\t 10 - Guardar\t 11 - Menu\t 12 - Sair ");
            }
            Scanner sc = new Scanner(System.in);
            try {
                c = sc.nextInt();
                switch (c) {
                    case 0:
                        jogo.realizarAccaoExtraPoint();
                        return;
                    case 1:
                        jogo.realizarAccaoArchersAtt();
                        return;
                    case 2:
                        jogo.realizarAccaoBoilWater();
                        return;
                    case 3:
                        jogo.realizarAccaoCloseCombat();
                        return;
                    case 4:
                        jogo.realizarAccaoCoupure();
                        return;
                    case 5:
                        jogo.realizarAccaoRallyTroops();
                        return;
                    case 6:
                        jogo.realizarAccaoTunnelMov();
                        return;
                    case 7:
                        jogo.realizarAccaoSupplyRaid();
                        return;
                    case 8:
                        jogo.realizarAccaoSabotage();
                        return;
                    case 9:
                        //obrigar jogador a combater inimigos quando existe 2 na linha de combate
                        if (jogo.checkTwoEnemiesCloseCombat() && jogo.getTurnActionPoints() > 0) {
                            String s = new String();
                            s = jogo.getLog();
                            System.out.println("\n----------------------- " + s + " -----------------------\n");
                        } else {
                            jogo.mudarTurno();
                        }
                        return;
                    case 10:
                        //falta testar
                        System.out.println("Insira o nome do jogo a guardar: ");
                        String nomeFicheiro = sc.next();
                        System.out.println("A guardar jogo");
                        GereFicheirosJogo.guardaJogo(jogo, nomeFicheiro);
                        return;
                    case 11:
                        jogo.novoJogo();
                        jogo = new Jogo();
                        return;
                    case 12:
                        System.out.println("A sair do jogo");
                        sair = true;
                        return;
                    default:
                        break;
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("Opção Invalida!");
            }
        }
    }

    void corre() throws IOException, FileNotFoundException, ClassNotFoundException {
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
            } else if (estado instanceof AguardaExtraPoint) {
                uiExtraPoints();
            } else if (estado instanceof FimJogo) {
                iuFimJogo();
            }
        }
    }
}

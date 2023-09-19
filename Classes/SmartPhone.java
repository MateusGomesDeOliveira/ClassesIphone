import Internet.Navegador;
import Ligacao.Telefone;
import Som.Musica;
import Som.Player;

public class SmartPhone implements Player, Navegador, Telefone {
    static private boolean tocandoMusica = false;
    static private Musica musicaAtual;
    static private int abas = 0;
    static private boolean recebendoLigacao = false;

    public static void main(String[] args) {
        SmartPhone sp = new SmartPhone();

        Musica musica1 = new Musica("Black");
        Musica musica2 = new Musica("Threshold");

        sp.tocar();
        sp.selecionarMusica(musica1);
        sp.pausar();
        sp.pausar();
        sp.tocar();
        sp.selecionarMusica(musica2);

        sp.exibirPagina("https://www.google.com/");
        sp.adicionarNovaAba();
        sp.atualizarPagina();
        sp.fecharAba();
        sp.fecharAba();
        sp.fecharAba();

        sp.ligar(981072537);
        sp.atender();
        recebendoLigacao = true;
        sp.atender();
        recebendoLigacao = true;
        sp.iniciarCorreioVoz();
        sp.recusarLigacao();
        sp.iniciarCorreioVoz();
    }
    //PLAYER//
    @Override
    public void selecionarMusica(Musica musica) {
        musicaAtual = musica;
        tocar();
    }
    @Override
    public void tocar() {
        if(musicaAtual != null){
            System.out.println("TOCANDO "+ musicaAtual.getNome());
            tocandoMusica = true;
        } else{
            System.out.println("SELECIONE UMA MUSICA PRIMEIRO!");
        }
    }
    @Override
    public void pausar() {
        if(tocandoMusica){
            System.out.println("MUSICA PAUSADA");
            tocandoMusica = false;
        } else {
            System.out.println("NENHUMA MUSICA TOCANDO!");
        }
    }
    //NAVEGADOR//
    @Override
    public void exibirPagina(String url) {
        if(abas == 0){
            abas = 1;
        }
        System.out.println("ACESSANDO SITE "+url);
    }
    @Override
    public void adicionarNovaAba() {
        System.out.println("ABA EM BRANCO ABERTA!");
        abas += 1;
    }
    @Override
    public void atualizarPagina() {
        System.out.println("PAGINA ATUALIZADA!");
    }
    @Override
    public void fecharAba() {
        if(abas != 0){
            System.out.println("ABA FECHADA!");
            abas -= 1;
        } else {
            System.out.println("NENHUMA ABA ABERTA!");
        }
    }
    //TELEFONE//
    @Override
    public void ligar(int numero) {
        System.out.println("LIGANDO PARA "+numero);
    }
    @Override
    public void atender() {
        if(recebendoLigacao){
            System.out.println("LIGACAO ATENDIDA");
            recebendoLigacao = false;
        }
    }
    @Override
    public void recusarLigacao() {
        if(recebendoLigacao){
            System.out.println("LIGACAO RECUSADA");
            recebendoLigacao = false;
        }
    }
    @Override
    public void iniciarCorreioVoz() {
        if(!recebendoLigacao){
            System.out.println("ABRINDO CORREIO DE VOZ");
        }
    }
}
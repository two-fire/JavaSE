package proxy;

public class XiMenQing {
    public static void main(String[] args) {

        WangPo wangPo = new WangPo();
        wangPo.makeEyesWithMen();
        wangPo.playWithMen();

        JiaShi jiashi = new JiaShi();
        WangPo wangPo1 = new WangPo(jiashi);
        wangPo1.makeEyesWithMen();
        wangPo1.playWithMen();
    }
}

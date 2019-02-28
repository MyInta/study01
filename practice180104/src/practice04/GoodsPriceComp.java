package practice04;
/**
 * 按价格排序的业务类（升序）
 * @author 银涛
 *
 */
public class GoodsPriceComp implements java.util.Comparator<Goods>{
	@Override
	public int compare(Goods arg0, Goods arg1) {
		return (arg0.getPrice()>arg1.getPrice()?1:arg0.getPrice()==arg1.getPrice()?
				arg0.getFav()>arg1.getFav()?1:-1:-1);
	}

}

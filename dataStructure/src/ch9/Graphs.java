package ch9;

import java.util.ArrayList;

/**
 * @ 判别一个有向图中是否有环路，并把所有环路打印出来。
 */
public class Graphs<T, E> {
	private T dot[];
	private E side[][];
	private int ctr = 0;
	private ArrayList<T> dotlist = new ArrayList<>();

	public Graphs(T[] t, E[][] e) {
		dot = t;
		side = e;
		for (int i = 0; i < dot.length; i++)
			dotlist.add(dot[i]);
	}

	private void print(ArrayList<T> path) {
		for (int j = 0; j < path.size(); j++) {
			System.out.print(path.get(j) + "—>");
		}
		System.out.print(path.get(0) + "\n");
		ctr++;
	}

	public void circle(int row, ArrayList<T> temp) {
		for (int i = 0; i < dot.length; i++) {
			// System.out.println(row + "  " + i);
			if (side[row][i] != null) {
				if (dot[i].equals(temp.get(0))) {                //有回路
					boolean isPrint = false;                  //检验是否已打印过
					for (int n = 0; n < temp.size() - 1; n++) {
						if (dotlist.indexOf(temp.get(n)) >= dotlist
								.indexOf(temp.get(n + 1))) {
							isPrint = true;
							break;
						}
					}
					if (!isPrint)
						print(temp);
				} else if (temp.contains(dot[i])) {            //检验线路中是否有重复点
					continue;
				} else {
					temp.add(dot[i]);
					circle(i, temp);               //递归
					temp.remove(dot[i]); // 记得要清理！！！
				}
			}
		}
	}

	public void go() {
		for (int i = 0; i < dot.length; i++) {
			ArrayList<T> temp = new ArrayList<T>();
			temp.add(dot[i]);
			circle(i, temp);
		}

		if (ctr == 0)
			System.out.println("No circle");
		else
			System.out.println(ctr + " circle(s) in total");
	}
	
	public static void main(String[] args) {
		Integer[][] e = { { null, 1, null,null,null }, { null, null, 1, null,null },
				{ null, null, null, 1,null }, { null, null, null, null ,1} ,{  1, null,null,null,null }};
		Integer[] t = { 1, 2, 3, 4 ,5};
		Graphs<Integer, Integer> g = new Graphs<>(t, e);
		g.go();
	}

}

package xiang;

public class DSU {
	int fa[], rank[];

	public DSU() {
		fa = new int[100];
		rank = new int[100];
	}

	public void makeset(int x) {
		fa[x] = x;
	}

	public int find(int x) {
		return (x != fa[x]) ? fa[x] = find(fa[x]) : x;
	}

	public void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) {
			return;
		}
		if(rank[x] > rank[y]){
			fa[y] = x;
		}else{
			fa[x] = y;
		}
		
		if(rank[x] == rank[y]){
			rank[y]++;
		}
	}

	public static void main(String[] args) {
		System.out.println("abcd".substring(1));

	}

}

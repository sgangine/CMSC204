import java.util.List;

public class Town implements Comparable<Town> {
	private String name;
	private List<Town> adjTowns;
	
	public Town(String name) {
		this.name = name;
	}
	
	public Town(Town templateTown) {
		this.name = templateTown.getName();
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public int compareTo(Town o) {
		return name.compareTo(o.getName());
	}
	
	public String toString() {
		return name;
	}
	
	public int hashCode() {
		return name.hashCode();
	}
	
	public boolean equals(Town obj) {
		return this.name.equals(obj.getName());
	}

}

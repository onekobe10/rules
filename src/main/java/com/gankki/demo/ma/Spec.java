package com.gankki.demo.ma;

class Spec {
	String size;
	String color;

	public Spec(String size, String color) {
		this.size = size;
		this.color = color;
	}

	@Override
	public String toString() {
		return "[size=" + size + ", color=" + color + "]";
	}

	/*@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Spec spec = (Spec) o;
		return Objects.equals(size, spec.size) &&
				Objects.equals(color, spec.color);
	}

	@Override
	public int hashCode() {
		return Objects.hash(size, color);
	}*/
}
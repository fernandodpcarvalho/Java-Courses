package com.testes.jvm.memory.escaping_references_02;

public interface BookReadOnly {

	int getId();

	String getTitle();

	String getAuthor();

	String toString();

	Price getPrice();

}
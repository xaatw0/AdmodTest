package com.ibuki101.admob;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class MyApplicationTest {

	@Test
	public void getMessage() {
		MyApplication target = new MyApplication();
		assertThat(target.getMessage(), is("admob was not loaded"));
	}

}

package com.example.testanno;

import java.util.ArrayList;
import java.util.List;

import com.hqew.core.annotation.CacheData;
import com.hqew.core.annotation.CacheData.SaveType;
import com.hqew.core.app.HQBaseFragment;

public class TestFragment extends HQBaseFragment {
	
	@CacheData(key="peo", isList=true, classType=Person.class, 
			saveType=SaveType.sharedPreferences) 
	List<Person> perons;
	@CacheData(key="n",classType=String.class,saveType=SaveType.file,fileName="name") String n;
	@CacheData(key="c",classType=String.class) String c;

	@Override
	protected int getContentView() {
		// TODO Auto-generated method stub
		return R.layout.f;
	}

	@Override
	public void doInitData() {
		// TODO Auto-generated method stub
		super.doInitData();
		
		if (perons == null) {
			System.out.println("person null");
		} else {
			System.out.println("doInitData: " + perons.toString());
		}
		if (n == null) {
			System.out.println("n null");
		} else {
			System.out.println("n: " + n);
		}
		if (c == null) {
			System.out.println("c null");
		} else {
			System.out.println("c: " + n);
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		
		System.out.println("onResume");
		
		Person p = new Person("test测试1", 1);
		if (perons == null) {
			perons = new ArrayList<Person>();
		}
		perons.add(p);
		n = System.currentTimeMillis() + "";
		c = "hello";
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		System.out.println("pause:");
	}

}

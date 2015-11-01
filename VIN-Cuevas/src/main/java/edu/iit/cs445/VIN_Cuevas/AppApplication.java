package edu.iit.cs445.VIN_Cuevas;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;


public class AppApplication extends ResourceConfig {
	
	public AppApplication(){
		final AddSubscriberDao dao = new AddSubscriberDao();
		final AddAdminDao aDao = new AddAdminDao();
		final AddWineDao wDao = new AddWineDao();
		final AddMonthlySelectionDao msDao = new AddMonthlySelectionDao();
		
		packages("edu.iit.cs445.VIN_Cuevas;");
		register(new AbstractBinder() {
			@Override
			protected void configure() {
				bind(dao).to(AddSubscriberDao.class);
			}
		});
		register(new AbstractBinder() {
			@Override
			protected void configure() {
				bind(aDao).to(AddAdminDao.class);
			}
		});
		register(new AbstractBinder() {
			@Override
			protected void configure() {
				bind(wDao).to(AddWineDao.class);
			}
		});
		register(new AbstractBinder() {
			@Override
			protected void configure() {
				bind(msDao).to(AddMonthlySelectionDao.class);
			}
		});
	}
}

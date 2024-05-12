package jp.example.configuration;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jp.example.resources.ProfileResource;
import jp.example.resources.MessageResource;

@ApplicationPath("/rest")
public class Application extends jakarta.ws.rs.core.Application {

	@Override
	public Set<Class<?>> getClasses() {

		Set<Class<?>> s = new HashSet<>();
		s.add(MessageResource.class);
		s.add(ProfileResource.class);

		return s;

	}

}

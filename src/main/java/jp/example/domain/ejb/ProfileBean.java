package jp.example.domain.ejb;

import java.time.LocalDate;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jp.example.dataaccess.entity.Profile;
import jp.example.dto.ProfileDto;
import lombok.extern.slf4j.Slf4j;

/**
 * Profile セッションBean.
 */
@Slf4j
@Stateless
public class ProfileBean {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * 指定したIDのプロフィール情報を取得する.
	 * 
	 * @param id ID
	 * @return 検索結果
	 */
	public Profile findById(int id) {

		return entityManager.find(Profile.class, id);
	}

	public ProfileDto findBy(int id) {

		var entity = findById(id);

		return makeProfileDto(entity);

	}

	/**
	 * プロフィール情報を登録する.
	 * 
	 * @param id ID
	 */
	public void register(int id) {

		var profile = new Profile();
		profile.setId(id);
		profile.setName("RegisterName " + String.valueOf(id));
		profile.setBirthDay(LocalDate.of(1982, id, id));
		entityManager.persist(profile);
		entityManager.flush();

	}

	/**
	 * プロフィール情報を登録する.
	 * 
	 * @param id ID
	 * @param name 名前
	 * @param birthDay 誕生日
	 * @return 登録結果
	 */
	public Profile register(int id, String name, LocalDate birthDay) {

		var profile = new Profile();
		profile.setId(id);
		profile.setName(name);
		profile.setBirthDay(birthDay);
		entityManager.persist(profile);
		entityManager.flush();

		return findById(id);

	}

	/**
	 * 指定したプロフィール情報を登録する.
	 * @param profileDto プロフィールDTO
	 * @return 登録結果
	 */
	public ProfileDto register(ProfileDto profileDto) {

		var entity = makeProfileEntity(profileDto);
		log.info("entity:{}", entity);
		entityManager.persist(entity);
		entityManager.flush();

		var registerResult = makeProfileDto(entity);
		log.info("registerResult:{}", registerResult);

		return registerResult;
	}

	public Profile makeProfileEntity(ProfileDto profileDto) {

		Profile entity = new Profile();
		entity.setId(profileDto.getId());
		entity.setName(profileDto.getName());
		entity.setBirthDay(profileDto.getBirthDay());
		return entity;
	}

	/**
	 * プロフィールエンティティからプロフィールDTOを生成する.
	 * 
	 * @param entity エンティティ
	 * @return プロフィールDTO
	 */
	public ProfileDto makeProfileDto(Profile entity) {

		var profileDto = new ProfileDto();
		profileDto.setId(entity.getId());
		profileDto.setName(entity.getName());
		profileDto.setBirthDay(entity.getBirthDay());
		return profileDto;
	}

}

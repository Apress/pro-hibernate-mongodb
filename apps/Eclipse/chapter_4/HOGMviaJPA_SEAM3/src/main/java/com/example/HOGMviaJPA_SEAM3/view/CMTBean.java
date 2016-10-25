package com.example.HOGMviaJPA_SEAM3.view;

import java.io.Serializable;
import java.util.Random;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.example.HOGMviaJPA_SEAM3.Forge;
import com.example.HOGMviaJPA_SEAM3.model.LuckyNumberEntity;

@Named("bean")
@Stateful
@RequestScoped
public class CMTBean implements Serializable
{

   private static final long serialVersionUID = 1L;

  @Inject @Forge EntityManager em;
  
  public void persistAction() {
	  LuckyNumberEntity luckyNumberEntity = new LuckyNumberEntity();
	  luckyNumberEntity.setLuckynumber(new Random().nextInt(1000000));
	  em.persist(luckyNumberEntity);
  }
}
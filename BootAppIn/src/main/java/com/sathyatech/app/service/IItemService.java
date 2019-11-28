package com.sathyatech.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.sathyatech.app.model.Item;

public interface IItemService {

	public Long save(Item item);
	public void update(Item item);
	public void delete(Long itemId);
	public Item getOne(Long itemId);
	public boolean isExist(Long itemId);
	public List<Item> getAll();
	public Page<Item> findAll(Pageable pageable);
	public Page<Item> findAll(Specification<Item> spec,Pageable page);
	public void save(List<Item> items);
	public List<Item> findItemsByVendor(Long vendorId);
}

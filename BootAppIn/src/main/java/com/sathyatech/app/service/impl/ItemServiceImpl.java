package com.sathyatech.app.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.sathyatech.app.model.Item;
import com.sathyatech.app.repo.ItemRepository;
import com.sathyatech.app.service.IItemService;

@Component
public class ItemServiceImpl implements IItemService {

	@Autowired
	private ItemRepository repo;
	
	@Override
	public Long save(Item item) {
		item = repo.save(item);//save or update
		return item.getItemId();
	}

	@Override
	public void update(Item item) {
		repo.save(item);
	}

	@Override
	public void delete(Long itemId) {
		repo.delete(itemId);
	}

	@Override
	public Item getOne(Long itemId) {
		Item item = repo.getOne(itemId);
		return item;
	}

	@Override
	public boolean isExist(Long itemId) {
		return repo.exists(itemId);
	}

	@Override
	public List<Item> getAll() {
		List<Item> itemList = repo.findAll();
		Collections.sort(itemList,new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return o1.getItemId().compareTo(o2.getItemId());
			}
		});
		 return itemList;
	}

	@Override
	public Page<Item> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public Page<Item> findAll(Specification<Item> spec, Pageable page) {
		return repo.findAll(spec, page);
	}

	@Override
	public void save(List<Item> items) {
		repo.save(items);
	}

	@Override
	public List<Item> findItemsByVendor(Long vendorId) {
		return repo.findItemsByVendor(vendorId);
	}
}

package project.dao;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.entities.CustomerInfoTable;
import project.entities.OrdersInfoTable;
import project.entities.PackagesInfoTable;
import project.repository.OrdersRepository;

@Repository
public class OrdersDAO {
	@Autowired
	OrdersRepository repo;

	public List<OrdersInfoTable> findAll() {

		return repo.findAll();
	}

	public void insertOrder(OrdersInfoTable obj) {
		repo.save(obj);
	}

	public void updateOrder(int id, PackagesInfoTable pk, Date orderdate, Date eventdate, Time eventtime,
			String eventvenue, int noofguest, double amount, String status) {
		OrdersInfoTable obj = repo.findById(id).get();

		obj.setPackagesInfoTable(pk);
		obj.setOrderDate(orderdate);
		obj.setEventDate(eventdate);
		obj.setEventTime(eventtime);
		obj.setEventVenue(eventvenue);
		obj.setNumberOfGuests(noofguest);
		obj.setOrderStatus(status);
		obj.setOrderAmount(amount);
		repo.save(obj);
	}

	public OrdersInfoTable getById(Integer id) {

		return repo.getById(id);
	}

	public Optional<OrdersInfoTable> findById(Integer id) {

		return repo.findById(id);
	}

	public void deleteById(Integer id) {
		repo.deleteById(id);

	}

	public void delete(OrdersInfoTable entity) {
		repo.delete(entity);

	}

	public void deleteAll() {
		repo.deleteAll();

	}

	public List<OrdersInfoTable> findbyCustomerId(CustomerInfoTable c) {
		int id = c.getCustomerId();
		return repo.findByCustomerId(id);
	}
}

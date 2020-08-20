package com.codegym.vn.services.bookingServiceImpl;

import com.codegym.vn.models.Booking;
import com.codegym.vn.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking findById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking remove(Long id) {

        Booking booking = this.findById(id);

        bookingRepository.deleteById(id);

        return booking;
    }

    @Override
    public Booking save(Booking model) {
        return null;
    }
}
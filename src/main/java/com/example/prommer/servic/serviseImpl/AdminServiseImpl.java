package com.example.prommer.servic.serviseImpl;

import com.example.prommer.model.users.Admin;
import com.example.prommer.repository.AdminRepository;
import com.example.prommer.servic.AdminServise;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiseImpl implements AdminServise {
    final private AdminRepository adminRepository;

    @Override
    public Admin adminGetAll() {
        return null;
    }
}

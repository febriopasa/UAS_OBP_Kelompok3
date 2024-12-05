-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 05 Des 2024 pada 14.15
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `donasi`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `donasi`
--

CREATE TABLE `donasi` (
  `id` int(20) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `status` enum('terkonfirmasi','belum_konfirmasi') NOT NULL DEFAULT 'belum_konfirmasi',
  `email` varchar(255) NOT NULL,
  `telepon` varchar(15) NOT NULL,
  `rekening` enum('bca','mandiri','bni') NOT NULL,
  `nominal` decimal(15,2) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `created_at_as_date` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `donasi`
--

INSERT INTO `donasi` (`id`, `nama`, `status`, `email`, `telepon`, `rekening`, `nominal`, `created_at`, `created_at_as_date`) VALUES
(1, 'Alejandra Garnacho', 'terkonfirmasi', 'garnachounited17@gmail.com', '081317298970', 'bca', 1200000.00, '2024-11-28 05:32:21', NULL),
(2, 'Febrio', 'terkonfirmasi', 'febrio@gmail.com', '09123429384', 'bca', 100000.00, '2024-11-28 08:04:39', NULL),
(3, 'Carlos', 'belum_konfirmasi', 'carlos@gmail.com', '0812345334543', 'bca', 150000.00, '2024-11-28 08:05:05', NULL),
(4, 'Louis', 'terkonfirmasi', 'louis@gmail.com', '08123423999432', 'mandiri', 250000.00, '2024-11-28 08:05:26', NULL),
(5, 'Kim', 'terkonfirmasi', 'kimjongun22@gmail.com', '081349872256', 'bni', 100000.00, '2024-11-30 15:19:37', NULL),
(6, 'Kanako', 'belum_konfirmasi', 'kanak0@gmail.com', '081388325674', 'bca', 300000.00, '2024-11-30 15:28:16', NULL),
(7, 'Maya', 'terkonfirmasi', 'mayamantap@gmail.com', '081222457789', 'mandiri', 50000.00, '2024-11-30 15:54:12', NULL),
(8, 'Raihandra', 'terkonfirmasi', 'raihandra17@gmail.com', '081299358934', 'mandiri', 250000.00, '2024-12-01 08:42:53', NULL),
(9, 'test', 'belum_konfirmasi', 'test1@gmail.com', '08128128128', 'bca', 250000.00, '2024-12-01 08:43:48', NULL),
(10, 'Michael', 'terkonfirmasi', 'michaelanakband1@gmail.com', '089682925816', 'bca', 50000.00, '2024-12-05 13:01:17', NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `password` varchar(255) NOT NULL,
  `username` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`password`, `username`) VALUES
('admin01', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penerima`
--

CREATE TABLE `penerima` (
  `penerima_id` int(11) NOT NULL,
  `penerima_nama` varchar(255) NOT NULL,
  `penerima_alamat` varchar(255) NOT NULL,
  `total_terima` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `penerima`
--

INSERT INTO `penerima` (`penerima_id`, `penerima_nama`, `penerima_alamat`, `total_terima`) VALUES
(1, 'RS_MITRA', 'Jl. Merdeka, NO.30 ', 450000),
(2, 'RS_PELITAJAYA', 'Jl. DewiSartika, NO.12, RT 02', 100000),
(3, 'RS_MEDIKA', 'Jl. Jatisari, NO.9 , RT 04 ', 50000),
(4, 'RS_HERMINA', 'Jl.Cikupa, NO. 87, RT.09', 2500000);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `donasi`
--
ALTER TABLE `donasi`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `login`
--
ALTER TABLE `login`
  ADD UNIQUE KEY `UK3svxcq6q51yfdg253l6x3dget` (`username`);

--
-- Indeks untuk tabel `penerima`
--
ALTER TABLE `penerima`
  ADD PRIMARY KEY (`penerima_id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `donasi`
--
ALTER TABLE `donasi`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT untuk tabel `penerima`
--
ALTER TABLE `penerima`
  MODIFY `penerima_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

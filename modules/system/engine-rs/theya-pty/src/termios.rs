use nix::sys::termios::{self, SetArg};
use anyhow::Result;
use std::os::unix::io::BorrowedFd;

pub fn set_raw_mode(fd: i32) -> Result<()> {
    let fd_ref = unsafe { BorrowedFd::borrow_raw(fd) };
    let mut termios = termios::tcgetattr(fd_ref)?;
    termios::cfmakeraw(&mut termios);
    termios::tcsetattr(fd_ref, SetArg::TCSANOW, &termios)?;
    Ok(())
}

use nix::sys::termios::Termios;
use anyhow::Result;

pub fn set_raw_mode(fd: i32) -> Result<()> {
    let mut termios = Termios::from_fd(fd)?;
    nix::sys::termios::cfmakeraw(&mut termios);
    nix::sys::termios::tcsetattr(fd, nix::sys::termios::SetArg::TCSANOW, &termios)?;
    Ok(())
}

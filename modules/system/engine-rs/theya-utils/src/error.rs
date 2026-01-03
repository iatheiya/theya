use thiserror::Error;

#[derive(Error, Debug)]
pub enum TheyaError {
    #[error("IO Error")]
    Io(#[from] std::io::Error),
    #[error("Unknown")]
    Unknown,
}

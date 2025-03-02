#[unsafe(no_mangle)]
pub extern "C" fn mul(a: f32, b: f32) -> f32 {
    a * b
}
